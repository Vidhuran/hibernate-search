/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.metadata.impl;

import org.hibernate.search.indexes.spi.IndexManager;

/**
 * @author Hardy Ferentschik
 */
public interface MetadataProvider {

	/**
	 * Returns the Search related metadata for the specified type.
	 *
	 * @param clazz The type of interest.
	 * @param indexManagerType the {@code IndexManager} type managing this entity type
	 *
	 * @return the {@code TypeMetadata} for the specified type
	 */
	TypeMetadata getTypeMetadataFor(Class<?> clazz, Class<? extends IndexManager> indexManagerType);

	/**
	 * Returns the ContainedIn related metadata for the specified type.
	 *
	 * The metadata for ContainedIn are not comprehensive: they do not
	 * contain the information about the FieldBridges. It's of no use
	 * for ContainedIn resolution and we can't build these information
	 * because classes only marked with {@code ContainedIn} are not tied
	 * to an {@code IndexManager}.
	 *
	 * @param clazz The type of interest.
	 *
	 * @return the {@code ContainedInTypeMetadata} for the specified type
	 */
	TypeMetadata getTypeMetadataForContainedIn(Class<?> clazz);

	boolean containsSearchMetadata(Class<?> clazz);
}
