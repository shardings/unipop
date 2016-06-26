package org.unipop.jdbc.schemas;

import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.unipop.schema.base.BaseVertexSchema;
import org.unipop.schema.property.PropertySchema;
import org.unipop.structure.UniGraph;

import java.util.List;

/**
 * @author GurRonen
 * @since 6/12/2016.
 */
public class RowVertexSchema extends BaseVertexSchema implements RowSchema<Vertex> {
    private final String table;

    public RowVertexSchema(List<PropertySchema> properties, UniGraph graph, String table) {
        super(properties, graph);

        this.table = table;

    }

    @Override
    public String getTable(Vertex element) {
        return this.table == null ? element.label() : this.table;
    }

    @Override
    public String getTable() {
        return this.table;
    }
}