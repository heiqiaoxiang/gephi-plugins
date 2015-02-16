/*
 * Your license here
 */

package com.carlschroedl.gephi.spanningtree;

import org.gephi.data.attributes.api.AttributeModel;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.statistics.spi.Statistics;
import org.gephi.utils.longtask.spi.LongTask;
import org.gephi.utils.progress.ProgressTicket;

/**
 *
 * See http://wiki.gephi.org/index.php/HowTo_write_a_metric#Create_Statistics
 *
 * @author Carl Schroedl <carlschroedl@gmail.com>
 */
public class SpanningTree implements Statistics, LongTask {

    private boolean cancel = false;
    private ProgressTicket progressTicket;
    private SpanningTreeAlgorithm stAlgorithm;
    
    private boolean directed;
    
    public SpanningTree(){
    }
    
    @Override
    //wrapper method for the UI only, selects the currently visible graph
    public void execute(GraphModel graphModel, AttributeModel attributeModel) {
        this.execute(graphModel.getGraphVisible(), attributeModel);
    }
    //a more general version of execute()
    public void execute(Graph graph, AttributeModel attributeModel){
        this.stAlgorithm = new KruskalsAlgorithm();
        stAlgorithm.execute(graph, attributeModel);
        
    }
    /** Only useful if the algorithm takes graph type into account. */

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    /** ----------------------------------------------------------- */

    @Override
    public String getReport() { //delegate
        //Write the report HTML string here
        return stAlgorithm.getReport();
    }

    @Override   //delegate
    public boolean cancel() {
        return stAlgorithm.cancel();
    }

    @Override
    public void setProgressTicket(ProgressTicket progressTicket) {
        this.progressTicket = progressTicket;
    }
}
