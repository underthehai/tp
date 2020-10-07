package seedu.address.model.commons;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.travelplan.TravelPlan;

/**
 * Tests that a {@code TravelPlanObject}'s or {@code TravelPlan}'s {@code Name} matches any of the keywords given.
 */
public class NameContainsKeywordsPredicate implements Predicate<Object> {
    private final List<String> keywords;

    public NameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Object obj) {
        if (obj instanceof TravelPlan) {
            return keywords.stream()
                    .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(((TravelPlan) obj).getName().name, keyword));
        } else if (obj instanceof TravelPlanObject) {
            return keywords.stream()
                    .anyMatch(keyword ->
                            StringUtil.containsWordIgnoreCase(((TravelPlanObject) obj).getName().name, keyword));
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((NameContainsKeywordsPredicate) other).keywords)); // state check
    }

}
