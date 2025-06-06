package pl.wsb.fitnesstracker.training.internal;

import lombok.Getter;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class TrainingResponseDto {
    private Long id;
    private User user;
    private Date startTime;
    private Date endTime;
    private ActivityType activityType;
    private double distance;
    private double averageSpeed;

    public TrainingResponseDto() {}

    public TrainingResponseDto(Long id, User user, Date startTime, Date endTime,
                               ActivityType activityType, double distance, double averageSpeed) {
        this.id = id;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }
}
