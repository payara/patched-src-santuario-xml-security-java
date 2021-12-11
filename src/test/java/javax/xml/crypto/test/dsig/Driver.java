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
package javax.xml.crypto.test.dsig;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used by ClassLoaderTest
 */
public class Driver {

    private static Logger log = Logger.getLogger(Driver.class.getName());

    public void dsig() throws Exception {

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance
            ("DOM", new org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            fac.newCanonicalizationMethod
                (CanonicalizationMethod.EXCLUSIVE, (C14NMethodParameterSpec) null);
        }
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        if (log.isLoggable(Level.FINE)) {
            log.log(Level.FINE, "Elapsed: " + elapsed);
            log.log(Level.FINE, "dsig succeeded");
        }
    }
}
