package seedu.address.logic.wanderlustlogic.wanderlustcommands.edit;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.wanderlustlogic.wanderlustcommands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.wanderlustlogic.wanderlustparser.CliSyntax.*;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.wanderlustlogic.wanderlustparser.ArgumentMultimap;
import seedu.address.logic.wanderlustlogic.wanderlustparser.ArgumentTokenizer;
import seedu.address.logic.wanderlustlogic.wanderlustparser.exceptions.ParseException;
import seedu.address.model.commons.Name;

public class EditDescriptorTest {

    private EditDescriptor editDescriptor = new EditDescriptor();

    @Test
    void isAnyFieldEdited_withNewEditDescriptor_returnsFalse() {
        assertFalse(editDescriptor.isAnyFieldEdited());
    }

    @Test
    void isAnyFieldEdited_withEditedNames_returnsTrue() {
        EditDescriptor editDescriptor = new EditDescriptor();
        editDescriptor.setName(new Name(VALID_NAME_AMY));
        assertTrue(editDescriptor.isAnyFieldEdited());
    }

    @Test
    void buildFromSource_withNull_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> EditDescriptor.buildFromSource(null));
    }

    @Test
    void buildFromSource_validArgumentMultimap_returnsCorrectEditDescriptor() {
        String args = NAME_DESC_AMY;
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME);
        try {
            editDescriptor = EditDescriptor.buildFromSource(argMultimap);
        } catch (ParseException e) {
            assert false;
        }
        EditDescriptor compareDescriptor = new EditDescriptor();
        compareDescriptor.setName(new Name(VALID_NAME_AMY));

        assertEquals(editDescriptor, compareDescriptor);

    }

    @Test
    void buildFromSource_validArgumentMultimap_returnsModifiedEditDescriptor(){
        String args = NAME_DESC_AMY;
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME);
        try {
            editDescriptor = EditDescriptor.buildFromSource(argMultimap);
        } catch (ParseException e) {
            assert false;
        }
        EditDescriptor compareDescriptor = new EditDescriptor();

        assertFalse(compareDescriptor.equals(editDescriptor));

    }

}
