package org.unipop.integration.suite;

import org.apache.tinkerpop.gremlin.GraphProviderClass;
import org.apache.tinkerpop.gremlin.structure.StructureStandardSuite;
import org.junit.runner.RunWith;
import org.unipop.ninteg.IntegGraphProvider;
import org.unipop.structure.UniGraph;

@RunWith(StructureStandardSuite.class)
@GraphProviderClass(provider = IntegGraphProvider.class, graph = UniGraph.class)
public class IntegrationStructureSuite {
}
