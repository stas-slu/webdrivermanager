/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
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

import org.junit.Assert;
import org.junit.Test;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

/**
 * Test asserting PhatomJS versions.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.3.2
 */
public class PhantomJsVersionTest {

	@Test
	public void testLatestVersion() throws Exception {
		PhantomJsDriverManager.getInstance().setup();
		String driverVersion = OperaDriverManager.getInstance()
				.getDownloadedVersion();
		Assert.assertNotNull(driverVersion);
	}

	@Test
	public void testSpecificVersions() throws Exception {
		String[] specificVersions = { "1.9.6", "1.9.7", "1.9.8", "2.1.1" };

		for (String specificVersion : specificVersions) {
			PhantomJsDriverManager.getInstance().setup(specificVersion);
			String driverVersion = PhantomJsDriverManager.getInstance()
					.getDownloadedVersion();

			Assert.assertEquals(specificVersion, driverVersion);
		}
	}

}
