package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyGradedTestList;
import seedu.address.model.gradedtest.Finals;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.gradedtest.MidTerms;
import seedu.address.model.gradedtest.PracticalExam;
import seedu.address.model.gradedtest.ReadingAssessment;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses {@code Collection<String> names} into a {@code Set<Name>}.
     */
    public static Set<Name> parseNames(Collection<String> names) throws ParseException {
        requireNonNull(names);
        final Set<Name> nameSet = new HashSet<>();
        for (String studentName : names) {
            if (!Name.isValidName(studentName)) {
                throw new ParseException(Name.MESSAGE_CONSTRAINTS);
            }
            nameSet.add(parseName(studentName));
        }
        return nameSet;
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses the input session number as a string and returns it as an integer.
     *
     * @param sessionNumber The session number to be parsed.
     * @return The parsed session number as an integer.
     * @throws NumberFormatException If the session number is not a valid integer.
     */
    public static SessionNumber parseSessionNumber(String sessionNumber) throws ParseException {
        requireNonNull(sessionNumber);
        String trimmedSessionNumber = sessionNumber.trim();
        if (!SessionNumber.isValidSessionNumber(trimmedSessionNumber)) {
            throw new ParseException(SessionNumber.MESSAGE_CONSTRAINTS);
        }
        return new SessionNumber(trimmedSessionNumber);
    }

    /**
     * Parses a {@code String taskName} into a {@code taskName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TaskName parseTaskName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!TaskName.isValidName(trimmedName)) {
            throw new ParseException(TaskName.MESSAGE_CONSTRAINTS);
        }
        return new TaskName(trimmedName);
    }

    /**
     * Parses a {@code String taskDescription} into a {@code taskDescription}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TaskDescription parseTaskDescription(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!TaskDescription.isValidDescription(trimmedName)) {
            throw new ParseException(TaskDescription.MESSAGE_CONSTRAINTS);
        }
        return new TaskDescription(trimmedName);
    }

    /**
     * Parses a {@code String gradedTest} into a {@code GradedTest}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code gradedTest} is invalid.
     */
    public static GradedTest parseGradedTest(String gradedTest) throws ParseException {
        requireNonNull(gradedTest);
        String trimmedGradedTest = gradedTest.trim();

        String[] components = trimmedGradedTest.split("\\s+");

        if (components.length != 5) {
            throw new ParseException("Invalid GradedTest format. Expected 5 components.");
        }

        ReadingAssessment readingAssessment1 = new ReadingAssessment(components[0]);
        ReadingAssessment readingAssessment2 = new ReadingAssessment(components[1]);
        MidTerms midTerms = new MidTerms(components[2]);
        Finals finals = new Finals(components[3]);
        PracticalExam practicalExam = new PracticalExam(components[4]);

        return new GradedTest(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
    }

    /**
     * Parses {@code Collection<String> gradedTest} into a {@code Set<GradedTest>}.
     */
    public static Set<GradedTest> parseGradedTests(Collection<String> gradedTests) throws ParseException {
        requireNonNull(gradedTests);
        final Set<GradedTest> gradedTestSet = new HashSet<>();
        for (String gradedTestName : gradedTests) {
            gradedTestSet.add(parseGradedTest(gradedTestName));
        }
        return gradedTestSet;
    }

    /**
     * Parses a {@code String readingAssessment} into a {@code readingAssessment}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static ReadingAssessment parseReadingAssessment(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!ReadingAssessment.isValidRaResult(trimmedName)) {
            throw new ParseException(ReadingAssessment.MESSAGE_CONSTRAINTS);
        }
        return new ReadingAssessment(trimmedName);
    }

    /**
     * Parses a {@code String readingAssessment} into a {@code readingAssessment}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static MidTerms parseMidTerms(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!MidTerms.isValidMidTermResult(trimmedName)) {
            throw new ParseException(MidTerms.MESSAGE_CONSTRAINTS);
        }
        return new MidTerms(trimmedName);
    }

    /**
     * Parses a {@code String finals} into a {@code finals}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Finals parseFinals(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Finals.isValidFinalsResult(trimmedName)) {
            throw new ParseException(Finals.MESSAGE_CONSTRAINTS);
        }
        return new Finals(trimmedName);
    }

    /**
     * Parses a {@code String practicalExam} into a {@code practicalExam}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static PracticalExam parsePracticalExam(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!PracticalExam.isValidPeResult(trimmedName)) {
            throw new ParseException(PracticalExam.MESSAGE_CONSTRAINTS);
        }
        return new PracticalExam(trimmedName);
    }
}
