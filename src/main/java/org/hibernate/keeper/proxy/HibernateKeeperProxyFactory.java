/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hibernate.keeper.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.ProxyFactory;
import org.hibernate.type.CompositeType;

/**
 * @author Serkan ÖZAL
 */
public class HibernateKeeperProxyFactory implements ProxyFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public void postInstantiate(String entityName, Class persistentClass,
			Set interfaces, Method getIdentifierMethod,
			Method setIdentifierMethod, CompositeType componentIdType)
			throws HibernateException {
		// TODO Auto-generated method stub
	}

	@Override
	public HibernateProxy getProxy(Serializable id, SessionImplementor session) throws HibernateException {
		return null;
	}

}
