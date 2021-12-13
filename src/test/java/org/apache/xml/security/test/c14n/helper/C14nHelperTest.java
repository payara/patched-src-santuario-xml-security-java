/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.xml.security.test.c14n.helper;

import org.apache.xml.security.c14n.helper.C14nHelper;

import java.util.logging.Logger;


/**
 * @author Christian Geuer-Pollmann
 */
public class C14nHelperTest extends org.junit.Assert {

    /** {@link org.apache.commons.logging} logging facility */
    static Logger log = Logger.getLogger(C14nHelperTest.class.getName());

    static {
        org.apache.xml.security.Init.init();
    }

    /**
     * Method testNamespaceIsAbsolute01
     */
    @org.junit.Test
    public void testNamespaceIsAbsolute01() {

        String namespaceURI = "http://www.w3.org/Signature/";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsAbsolute(namespaceURI));
    }

    /**
     * @see <A HREF="http://lists.w3.org/Archives/Public/w3c-ietf-xmldsig/2001JulSep/0068.html">The list</A>
     */
    @org.junit.Test
    public void testNamespaceIsAbsolute02() {

        String namespaceURI = "http://www.w3.org/../blah";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsAbsolute(namespaceURI));
    }

    /**
     * Method testNamespaceIsAbsolute03
     */
    @org.junit.Test
    public void testNamespaceIsAbsolute03() {

        // unknown protocol?
        String namespaceURI = "hxxp://www.w3.org/";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsAbsolute(namespaceURI));
    }

    /**
     * Method testNamespaceIsRelative01
     */
    @org.junit.Test
    public void testNamespaceIsRelative01() {

        String namespaceURI = "../blah";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsRelative(namespaceURI));
    }

    /**
     * Method testNamespaceIsRelative02
     */
    @org.junit.Test
    public void testNamespaceIsRelative02() {

        String namespaceURI = "blah";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsRelative(namespaceURI));
    }

    /**
     * Method testNamespaceIsRelative03
     */
    @org.junit.Test
    @org.junit.Ignore
    public void testNamespaceIsRelative03() {

        String namespaceURI = "http://...";

        assertTrue("URI fails: \"" + namespaceURI + "\"",
                   C14nHelper.namespaceIsRelative(namespaceURI));
    }

}
