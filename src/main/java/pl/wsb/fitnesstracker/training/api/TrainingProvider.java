package pl.wsb.fitnesstracker.training.api;

import pl.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.Date;
import java.util.List;

/**
 * Interface responsible for providing training data.
 * Contains methods to retrieve trainings based on various criteria.
 */
public interface TrainingProvider {

    /**
     * Returns a list of all trainings.
     *
     * @return list of all trainings
     */
    List<Training> findAllTraining();

    /**
     * Returns a list of all trainings assigned to a specific user.
     *
     * @param userId the ID of the user
     * @return list of trainings for the given user
     */
    List<Training> findAllTrainingForUser(Long userId);

    /**
     * Returns a list of trainings filtered by activity type.
     *
     * @param activityType the type of activity (e.g., RUNNING, TENNIS)
     * @return list of trainings with the specified activity type
     */
    List<Training> findTrainingsByActivityType(ActivityType activityType);

    /**
     * Returns a list of trainings that ended after the specified date.
     *
     * @param date the date after which trainings ended
     * @return list of trainings ended after the given date
     */
    List<Training> findTrainingsEndedAfter(Date date);
}
