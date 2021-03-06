//
// ========================================================================
// Copyright (c) 1995-2020 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under
// the terms of the Eclipse Public License 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0
//
// This Source Code may also be made available under the following
// Secondary Licenses when the conditions for such availability set
// forth in the Eclipse Public License, v. 2.0 are satisfied:
// the Apache License v2.0 which is available at
// https://www.apache.org/licenses/LICENSE-2.0
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.session.infinispan;

import org.eclipse.jetty.server.session.SessionData;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.commons.api.BasicCache;

public class RemoteQueryManagerFactory implements QueryManagerFactory
{

    @Override
    public QueryManager getQueryManager(BasicCache<String, SessionData> cache)
    {
        System.err.println(cache.getClass().getName());
        if (!RemoteCache.class.isAssignableFrom(cache.getClass()))
            throw new IllegalArgumentException("Argument is not of type RemoteCache");

        return new RemoteQueryManager((RemoteCache<String, SessionData>)cache);
    }
}
