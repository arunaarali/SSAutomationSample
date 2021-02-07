package test_utils.homepage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public enum HomePageItems {
    HOME_PAGE_TITLE("The Banner Saga"),
    GAMES("GAMES"),
    DISCORD("DISCORD"),
    NEWS("NEWS"),
    STORE("STORE"),
    ABOUT_US("ABOUT US"),
    CONTACT("CONTACT");

    @Getter
    String getValue;

}
