/**
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.cloudhopper.commons.sql.adapter;

// java imports
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.DriverManager;

// my imports

/**
 * Basic DataSource implementation to provide a thin layer to obtain
 * connections directly from the DriverManager.
 * 
 * @author joelauer
 */
public class BasicDataSource implements DataSource {

    private String url;
    private String username;
    private String password;

    public BasicDataSource(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        // driver is already registered by SimpleAdapter
        // create the connection
        return DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection(String user, String pass) throws SQLException {
        // driver is already registered by SimpleAdapter
        // create the connection
        return DriverManager.getConnection(url, user, pass);
    }

    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        // do nothing
    }

    public int getLoginTimeout() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
