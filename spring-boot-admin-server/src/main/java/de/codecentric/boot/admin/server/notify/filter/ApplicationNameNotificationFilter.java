/*
 * Copyright 2014-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.codecentric.boot.admin.server.notify.filter;

import de.codecentric.boot.admin.server.domain.entities.Application;
import de.codecentric.boot.admin.server.domain.events.ClientApplicationEvent;

public class ApplicationNameNotificationFilter extends ExpiringNotificationFilter {
    private final String name;

    public ApplicationNameNotificationFilter(String name, long expiry) {
        super(expiry);
        this.name = name;
    }

    @Override
    protected boolean doFilter(ClientApplicationEvent event, Application application) {
        return name.equals(application.getRegistration().getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NotificationFilter [name=" + name + ", expiry=" + getExpiry() + "]";
    }
}