/*
 * (C) Copyright 2015 Boni Garcia (http://bonigarcia.github.io/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package io.github.bonigarcia.wdm.test;

import io.github.bonigarcia.wdm.MarionetteDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Test with Marionette browser.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.3.2
 */
public class MarionetteTest extends ManagerTest{

    @BeforeClass
    public static void setupClass() {
        MarionetteDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        // This capability set need for beta\dev\nightly(version 45+) firefox because this driver is target on it
        if (SystemUtils.IS_OS_LINUX) {
            capabilities.setCapability("binary", "/usr/bin/firefox");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            capabilities.setCapability("binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            capabilities.setCapability("binary", "/Applications/Firefox.app");
        }
        driver = new MarionetteDriver(capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMarionette() {
        browseWikipedia();
    }
}
