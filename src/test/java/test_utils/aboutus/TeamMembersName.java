package test_utils.aboutus;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public enum TeamMembersName {
    ARNIE_JORGENSEN("Arnie Jorgensen"),
    JOHN_WATSON("John Watson"),
    TRISHA_STOUFFER("Trisha Stouffer"),
    ALEX_THOMAS("Alex Thomas"),
    MATT_BERNEY("Matt Barney");

    public String getFullName;

}
