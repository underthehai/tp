package seedu.address.model.travelplanner;

/**
 * Represents the current directory of wanderlust, which can be instance of TravelPlan or Wishlist
 */
public abstract class Directory {
    /**
     * Returns true if current directory is a travel plan, false otherwise.
     */
    public abstract boolean isTravelPlan();

    /**
     * Returns true if current directory is a wishlist, false otherwise.
     */
    public abstract boolean isWishlist();
}
