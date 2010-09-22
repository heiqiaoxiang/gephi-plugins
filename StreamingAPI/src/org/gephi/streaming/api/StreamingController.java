/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>, Andre Panisson <panisson@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.gephi.streaming.api;

import java.io.IOException;
import org.gephi.graph.api.Graph;

/**
 * Controller to connect to graph streams and update graphs accordingly.
 *
 * @author panisson
 */
public interface StreamingController {

    /**
     * <p>This is used to connect to a StreamingEndpoint. The connection will be
     * bound with the Graph object: any event received in the stream will cause
     * an update in the graph, and updates in the graph will cause an event
     * to be sent to the StreamingEndpoint.
     * <p>Note that the connection will not start to be processed immediately after
     * created. You should call connection.process() to star processing it:
     * <pre> StreamingController controller = Lookup.getDefault().lookup(StreamingController.class);
     * StreamingConnection connection = controller.connect(endpoint, graph);
     * connection.process(); </pre>
     *
     * @param endpoint - the StreamingEndpoint to connect to
     * @param graph - the Graph that will be updated with the events
     * @return the streaming connection
     * @throws IOException
     */
    public StreamingConnection connect(StreamingEndpoint endpoint, Graph graph)
            throws IOException;

    /**
     * <p>This is used to connect to a StreamingEndpoint. The connection will be
     * bound with the Graph object: any event received in the stream will cause
     * an update in the graph, and updates in the graph will cause an event
     * to be sent to the StreamingEndpoint.
     * The Report object will be updated
     * with useful information.
     * <p>Note that the connection will not start to be processed immediately after
     * created. You should call connection.process() to star processing it:
     * <pre> StreamingController controller = Lookup.getDefault().lookup(StreamingController.class);
     * Report report = new Report();
     * StreamingConnection connection = controller.connect(endpoint, graph, report);
     * connection.process(); </pre>
     *
     * @param endpoint - the StreamingEndpoint to connect to
     * @param graph - the Graph that will be updated with the events
     * @param report - the Report object that will be updated with information
     * @return the streaming connection
     * @throws IOException
     */
    public StreamingConnection connect(StreamingEndpoint endpoint, Graph graph,
            Report report)
            throws IOException;

    /**
     * Utility function to get the stream implementation for a given stream type.
     *
     * @param streamType - the String representation of the stream type
     * @return the stream type implementation
     */
    public StreamType getStreamType(String streamType);
}
