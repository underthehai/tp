package seedu.address.model.travelplan.exceptions;

/**
 * Signals that the operation will result in duplicate TravelPlans (TravelPlans are considered duplicates if they have
 * the same
 * identity).
 */
public class DuplicateTravelPlanException extends RuntimeException {
    public DuplicateTravelPlanException() {
        super("Operation would result in duplicate persons");
    }
}
