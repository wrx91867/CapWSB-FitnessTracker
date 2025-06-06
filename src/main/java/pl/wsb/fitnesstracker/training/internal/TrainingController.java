package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingServiceImpl trainingService;


    private final TrainingMapper trainingMapper;

    @GetMapping
    public List<TrainingResponseDto> getAllTrainings() {
        return trainingService.findAllTraining()
                .stream()
                .map(trainingMapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingResponseDto createTraining(@RequestBody TrainingRequestDto trainingDto) {
        Training training = trainingMapper.toEntity(trainingDto);
        Training saved = trainingService.createTraining(training);
        return trainingMapper.toResponseDto(saved);
    }

    @GetMapping("/{userId}")
    public List<TrainingResponseDto> getAllTrainingsForUser(@PathVariable Long userId) {
        return trainingService.findAllTrainingForUser(userId)
                .stream()
                .map(trainingMapper::toResponseDto)
                .toList();
    }

    @GetMapping("/finished/{afterTime}")
    public List<TrainingResponseDto> getFinishedTrainingsAfter(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date afterTime) {
        return trainingService.findTrainingsEndedAfter(afterTime)
                .stream()
                .map(trainingMapper::toResponseDto)
                .toList();
    }

    @GetMapping("/activityType")
    public List<TrainingResponseDto> getTrainingsByActivityType(@RequestParam ActivityType activityType) {
        return trainingService.findTrainingsByActivityType(activityType)
                .stream()
                .map(trainingMapper::toResponseDto)
                .toList();
    }


    @PutMapping("/{trainingId}")
    public TrainingResponseDto updateTraining(@PathVariable Long trainingId, @RequestBody TrainingRequestDto trainingDto) {
        Training newTraining = trainingMapper.toEntity(trainingDto);
        Training updated = trainingService.updateTraining(trainingId, newTraining);
        return trainingMapper.toResponseDto(updated);
    }
}
