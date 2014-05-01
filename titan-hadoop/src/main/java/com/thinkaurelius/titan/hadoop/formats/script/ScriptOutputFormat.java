package com.thinkaurelius.titan.hadoop.formats.script;

import com.thinkaurelius.titan.hadoop.FaunusVertex;
import com.thinkaurelius.titan.hadoop.formats.HadoopFileOutputFormat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScriptOutputFormat extends HadoopFileOutputFormat {

    public static final String FAUNUS_GRAPH_OUTPUT_SCRIPT_FILE = "faunus.graph.output.script.file";

    @Override
    public RecordWriter<NullWritable, FaunusVertex> getRecordWriter(final TaskAttemptContext job) throws IOException, InterruptedException {
        return new ScriptRecordWriter(super.getDataOuputStream(job), job.getConfiguration());
    }
}