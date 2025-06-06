package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.training.api.TrainingProvider;
import pl.wsb.fitnesstracker.training.api.TrainingService;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
class TrainingServiceImpl implements TrainingProvider, TrainingService {

    private final TrainingRepository trainingRepository;

    @Override
    public List<Training> findAllTraining() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> findAllTrainingForUser(Long userId) {
        return trainingRepository.findByUser_Id(userId);
    }

    @Override
    public List<Training> findTrainingsByActivityType(ActivityType activityType) {
        return trainingRepository.findByActivityType(activityType);
    }

    @Override
    public List<Training> findTrainingsEndedAfter(Date date) {
        return trainingRepository.findByEndTimeAfter(date);
    }

    @Override
    public Training createTraining(Training training) {
        if (training.getId() != null) {
            throw new IllegalArgumentException("New training cannot already have an ID.");
        }
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long trainingId, Training newTrainingData) {
        Training existingTraining = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new IllegalArgumentException("Training not found with ID: " + trainingId));

        existingTraining.setUser(newTrainingData.getUser());
        existingTraining.setStartTime(newTrainingData.getStartTime());
        existingTraining.setEndTime(newTrainingData.getEndTime());
        existingTraining.setActivityType(newTrainingData.getActivityType());
        existingTraining.setDistance(newTrainingData.getDistance());
        existingTraining.setAverageSpeed(newTrainingData.getAverageSpeed());

        return trainingRepository.save(existingTraining);
    }

}
