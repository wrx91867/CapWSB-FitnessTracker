package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.user.api.User;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUser_Id(Long userId);

    List<Training> findByActivityType(ActivityType activityType);

    List<Training> findByEndTimeAfter(Date date);
}
