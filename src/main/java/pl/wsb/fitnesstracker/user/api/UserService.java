package pl.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {
    /**
     * Creates a new user in the system.
     * The {@link User#getId()} of the provided user must be {@code null},
     * otherwise an {@link IllegalArgumentException} may be thrown.
     *
     * @param user the user entity to create
     * @return the created user entity with assigned ID
     * @throws IllegalArgumentException if the user already has an ID
     */
    User createUser(User user);
    /**
     * Deletes a user identified by the given ID.
     *
     * @param userId the ID of the user to delete
     * @throws IllegalArgumentException if no user with the given ID exists
     */
    void deleteUser(Long userId);
    /**
     * Updates an existing user identified by the given ID with new user data.
     * Updates all modifiable fields such as first name, last name, birthdate, and email.
     *
     * @param userId the ID of the user to update
     * @param newUserData the new user data to update the existing user with
     * @return the updated user entity
     * @throws IllegalArgumentException if no user with the given ID exists
     */
    User updateUser(Long userId, User newUserData);
}
