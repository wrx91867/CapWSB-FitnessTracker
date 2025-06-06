package pl.wsb.fitnesstracker.training.api;


/**
 * Service interface for managing trainings.
 * Provides methods to create and update training records.
 */
public interface TrainingService {

    /**
     * Creates a new training record.
     *
     * @param training the training entity to create
     * @return the created training entity
     */
    Training createTraining(Training training);

    /**
     * Updates an existing training record.
     *
     * @param trainingId the ID of the training to update
     * @param newTrainingData the new training data to apply
     * @return the updated training entity
     */
    Training updateTraining(Long trainingId, Training newTrainingData);
}
