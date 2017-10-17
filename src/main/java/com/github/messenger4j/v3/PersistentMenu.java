package com.github.messenger4j.v3;

import com.github.messenger4j.setup.CallToAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public final class PersistentMenu {

    private final List<LocalizedPersistentMenu> localizedPersistentMenus;

    public static PersistentMenu create(boolean composerInputDisabled, List<CallToAction> callToActions,
                                        @NonNull LocalizedPersistentMenu... localizedPersistentMenus) {

        final List<LocalizedPersistentMenu> localizedPersistentMenuList = new ArrayList<>(localizedPersistentMenus.length + 1);
        localizedPersistentMenuList.add(LocalizedPersistentMenu.create("default", composerInputDisabled, callToActions));
        localizedPersistentMenuList.addAll(Arrays.asList(localizedPersistentMenus));
        return new PersistentMenu(localizedPersistentMenuList);
    }

    private PersistentMenu(List<LocalizedPersistentMenu> localizedPersistentMenus) {
        this.localizedPersistentMenus = Collections.unmodifiableList(localizedPersistentMenus);
    }

    public List<LocalizedPersistentMenu> localizedPersistentMenus() {
        return localizedPersistentMenus;
    }
}