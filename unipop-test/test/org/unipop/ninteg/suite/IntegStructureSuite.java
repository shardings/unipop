package org.unipop.ninteg.suite;

import org.apache.tinkerpop.gremlin.GraphProviderClass;
import org.junit.runner.RunWith;
import org.unipop.ninteg.IntegGraphProvider;
import org.unipop.structure.UniGraph;
import org.unipop.test.UnipopStructureSuite;

@RunWith(UnipopStructureSuite.class)
@GraphProviderClass(provider = IntegGraphProvider.class, graph = UniGraph.class)
public class IntegStructureSuite {
}
