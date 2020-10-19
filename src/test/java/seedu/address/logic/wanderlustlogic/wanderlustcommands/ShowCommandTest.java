package seedu.address.logic.wanderlustlogic.wanderlustcommands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustparser.WanderlustShowCommandParser;
import seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException;

public class ShowCommandTest {
    @Test
    public void execute_show_success() {
        try {
            ShowCommand expectedCommand = new ShowCommand("activity");
            Assertions.assertTrue(expectedCommand.equals(new WanderlustShowCommandParser().parse(" -activity")));
        } catch (ParseException pe) {
            System.out.println("Invalid input!");
        }
    }

    @Test
    public void execute_goto_failure() {
        try {
            ShowCommand expectedCommand = new ShowCommand("friend");
            Assertions.assertFalse(expectedCommand.equals(new WanderlustShowCommandParser().parse(" -friends")));
        } catch (ParseException pe) {
            System.out.println("Invalid input!");
        }
    }
}
