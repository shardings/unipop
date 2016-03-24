package org.unipop.process.group;

import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.step.util.ReducingBarrierStep;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Element;
import org.unipop.structure.manager.ControllerManager;
import org.unipop.structure.manager.ControllerProvider;
import org.unipop.controller.Predicates;

import java.util.*;

/**
 * Created by Gilad on 03/11/2015.
 */
public class UniGraphGroupStep<E extends Element> extends ReducingBarrierStep<E, Map<String, Object>> {
    //region Constructor
    public UniGraphGroupStep(
            Traversal.Admin traversal,
            Class elementClass,
            Predicates predicates,
            Object[] ids,
            String[] edgeLabels,
            Optional<Direction> direction,
            ControllerManager controllerManager) {
        super(traversal);

        this.controllerManager = controllerManager;
        this.bulk = new ArrayList<>();

//        this.setSeedSupplier(() -> {
//            return null;
//            if (!this.previousStep.equals(EmptyStep.instance())) {
//                return new HashMap<>();
//            }
//
//            if (Vertex.class.isAssignableFrom(elementClass)) {
//                return this.controllerManager.getControllers(GroupController.class).vertexGroupBy(
//                        predicates,
//                        keyTraversal,
//                        valuesTraversal,
//                        reducerTraversal);
//            } else {
//                return this.controllerManager.edgeGroupBy(
//                        predicates,
//                        keyTraversal,
//                        valuesTraversal,
//                        reducerTraversal);
//            }
//        });
//
//        this.setBiFunction((seed, traverser) -> {
//            E element = traverser.get();
//            bulk.add(element);
//
//            Map<String, Object> bulkGroupBy = null;
//            //TODO: configure bulk size dynamically
//            if (bulk.size() > 100 || !this.starts.hasNext()) {
//                bulkGroupBy = this.controllerManager.edgeGroupBy(
//                        (Vertex[]) bulk.toArray(),
//                        direction.get(),
//                        edgeLabels,
//                        predicates,
//                        keyTraversal,
//                        valuesTraversal,
//                        reducerTraversal);
//
//                bulk.clear();
//            }
//
//            // merge the result with the seed
//            for(Map.Entry<String, Object> entry : bulkGroupBy.entrySet()) {
//                seed.get(entry.getKey())
//                seed.put(entry.getKey(), entry.getValue());
//            }
//
//            return seed;
//        });
    }
    //endregion

    //region Properties
    public Traversal getKeyTraversal() {
        return this.keyTraversal;
    }

    public void setKeyTraversal(Traversal value) {
        this.keyTraversal = value;
    }

    public Traversal getValuesTraversal() {
        return this.valuesTraversal;
    }

    public void setValuesTraversal(Traversal value) {
        this.valuesTraversal = value;
    }

    public Traversal getReducerTraversal() {
        return this.reducerTraversal;
    }

    public void setReducerTraversal(Traversal value) {
        this.reducerTraversal = value;
    }
    //endregion

    //region Fields
    private ControllerManager controllerManager;
    private Collection<E> bulk;

    private Traversal keyTraversal;
    private Traversal valuesTraversal;
    private Traversal reducerTraversal;
    //endregion
}