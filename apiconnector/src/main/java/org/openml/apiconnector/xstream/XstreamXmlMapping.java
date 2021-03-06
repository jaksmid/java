/*
 *  OpenmlApiConnector - Java integration of the OpenML Web API
 *  Copyright (C) 2014 
 *  @author Jan N. van Rijn (j.n.van.rijn@liacs.leidenuniv.nl)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package org.openml.apiconnector.xstream;

import org.openml.apiconnector.xml.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XstreamXmlMapping {

    /**
     * Generates a bidirectional mapping between the XML Objects (server) and
     * the Java Objects (OpenmlApiConnector package opg.openml.apiconnector.xml).
     *
     * @return XStream - An XStream instance capable of mapping XML objects and
     * OpenmlApiConnector Objects to each other.
     */
    public static XStream getInstance() {
        XStream xstream = new XStream(new DomDriver("UFT-8", new NoNameCoder()));
        xstream.ignoreUnknownElements();

        // data
        xstream.alias("oml:data", Data.class);
        xstream.aliasAttribute(Data.class, "oml", "xmlns:oml");
        xstream.addImplicitCollection(Data.class, "data", "oml:dataset", Data.DataSet.class);

        // Data.DataSet
        xstream.alias("oml:dataset", Data.DataSet.class);
        xstream.aliasField("oml:did", Data.DataSet.class, "did");
        xstream.aliasField("oml:status", Data.DataSet.class, "status");
        xstream.aliasField("oml:name", Data.DataSet.class, "name");

        xstream.addImplicitCollection(Data.DataSet.class, "qualities", "oml:quality", Data.DataSet.Quality.class);
        xstream.useAttributeFor(Data.DataSet.Quality.class, "name");
        xstream.registerConverter(new ToAttributedValueConverter(Data.DataSet.Quality.class, xstream.getMapper(), xstream.getReflectionProvider(), xstream.getConverterLookup(), "value"));


        // data set description
        xstream.alias("oml:data_set_description", DataSetDescription.class);
        xstream.aliasAttribute(DataSetDescription.class, "oml", "xmlns:oml");

        xstream.addImplicitCollection(DataSetDescription.class, "creator", "oml:creator", String.class);
        xstream.addImplicitCollection(DataSetDescription.class, "contributor", "oml:contributor", String.class);
        xstream.addImplicitCollection(DataSetDescription.class, "ignore_attribute", "oml:ignore_attribute", String.class);
        xstream.addImplicitCollection(DataSetDescription.class, "tag", "oml:tag", String.class);


        xstream.aliasField("oml:id", DataSetDescription.class, "id");
        xstream.aliasField("oml:name", DataSetDescription.class, "name");
        xstream.aliasField("oml:version", DataSetDescription.class, "version");
        xstream.aliasField("oml:description", DataSetDescription.class, "description");
        xstream.aliasField("oml:format", DataSetDescription.class, "format");
        xstream.aliasField("oml:collection_date", DataSetDescription.class, "collection_date");
        xstream.aliasField("oml:language", DataSetDescription.class, "language");
        xstream.aliasField("oml:upload_date", DataSetDescription.class, "upload_date");
        xstream.aliasField("oml:licence", DataSetDescription.class, "licence");
        xstream.aliasField("oml:url", DataSetDescription.class, "url");
        xstream.aliasField("oml:row_id_attribute", DataSetDescription.class, "row_id_attribute");
        xstream.aliasField("oml:default_target_attribute", DataSetDescription.class, "default_target_attribute");
        xstream.aliasField("oml:visibility", DataSetDescription.class, "visibility");
        xstream.aliasField("oml:md5_checksum", DataSetDescription.class, "md5_checksum");

        xstream.omitField(DataSetDescription.class, "dataset_cache");

        // data feature
        xstream.alias("oml:data_features", DataFeature.class);
        xstream.aliasField("oml:did", DataFeature.class, "did");
        xstream.aliasField("oml:error", DataFeature.class, "error");
        xstream.aliasAttribute(DataFeature.class, "oml", "xmlns:oml");
        xstream.addImplicitCollection(DataFeature.class, "features", "oml:feature", DataFeature.Feature.class);

        xstream.alias("oml:data_feature", DataFeature.Feature.class);
        xstream.aliasField("oml:index", DataFeature.Feature.class, "index");
        xstream.aliasField("oml:name", DataFeature.Feature.class, "name");
        xstream.aliasField("oml:data_type", DataFeature.Feature.class, "data_type");
        xstream.aliasField("oml:is_target", DataFeature.Feature.class, "is_target");
        xstream.aliasField("oml:NumberOfDistinctValues", DataFeature.Feature.class, "NumberOfDistinctValues" );
        xstream.aliasField("oml:NumberOfUniqueValues", DataFeature.Feature.class, "NumberOfUniqueValues" );
        xstream.aliasField("oml:NumberOfMissingValues", DataFeature.Feature.class, "NumberOfMissingValues" );
        xstream.aliasField("oml:NumberOfIntegerValues", DataFeature.Feature.class, "NumberOfIntegerValues" );
        xstream.aliasField("oml:NumberOfRealValues", DataFeature.Feature.class, "NumberOfRealValues" );
        xstream.aliasField("oml:NumberOfNominalValues", DataFeature.Feature.class, "NumberOfNominalValues" );
        xstream.aliasField("oml:NumberOfValues", DataFeature.Feature.class, "NumberOfValues" );
        xstream.aliasField("oml:MaximumValue", DataFeature.Feature.class, "MaximumValue" );
        xstream.aliasField("oml:MinimumValue", DataFeature.Feature.class, "MinimumValue" );
        xstream.aliasField("oml:MeanValue", DataFeature.Feature.class, "MeanValue" );
        xstream.aliasField("oml:StandardDeviation", DataFeature.Feature.class, "StandardDeviation" );
        xstream.aliasField("oml:ClassDistribution", DataFeature.Feature.class, "ClassDistribution" );


        // data quality
        xstream.alias("oml:data_qualities", DataQuality.class);
        xstream.aliasField("oml:did", DataQuality.class, "did");
        xstream.aliasField("oml:error", DataQuality.class, "error");
        xstream.aliasAttribute(DataQuality.class, "oml", "xmlns:oml");
        xstream.addImplicitCollection(DataQuality.class, "qualities", "oml:quality", DataQuality.Quality.class);

        xstream.alias("oml:data_quality", DataQuality.Quality.class);
        xstream.aliasField("oml:name", DataQuality.Quality.class, "name");
        xstream.aliasField("oml:value", DataQuality.Quality.class, "value");
        xstream.useAttributeFor(DataQuality.Quality.class, "interval_start");
        xstream.useAttributeFor(DataQuality.Quality.class, "interval_end");

        // data qualities upload
        xstream.alias("oml:data_qualities_upload", DataQualityUpload.class);
        xstream.aliasField("oml:did", DataQualityUpload.class, "did");

        // data qualities list
        xstream.alias("oml:data_qualities_list", DataQualityList.class);
        xstream.addImplicitCollection(DataQualityList.class, "quality", "oml:quality", String.class);

        // data licences list
        xstream.alias("oml:data_licences", LicencesList.class);
        xstream.aliasAttribute(LicencesList.class, "oml", "xmlns:oml");
        xstream.aliasField("oml:licences", LicencesList.class, "licences");
        xstream.addImplicitCollection(LicencesList.Licences.class, "licences", "oml:licence", String.class);

        // data features upload
        xstream.alias("oml:data_features_upload", DataFeatureUpload.class);
        xstream.aliasField("oml:did", DataFeatureUpload.class, "did");

        // upload data set
        xstream.alias("oml:upload_data_set", UploadDataSet.class);
        xstream.aliasField("oml:id", UploadDataSet.class, "id");

        // implementation
        xstream.alias("oml:implementation", Implementation.class);
        xstream.aliasAttribute(Implementation.class, "oml", "xmlns:oml");

        xstream.addImplicitCollection(Implementation.class, "creator", "oml:creator", String.class);
        xstream.addImplicitCollection(Implementation.class, "contributor", "oml:contributor", String.class);
        xstream.addImplicitCollection(Implementation.class, "bibliographical_reference", "oml:bibliographical_reference", Implementation.Bibliographical_reference.class);
        xstream.addImplicitCollection(Implementation.class, "parameter", "oml:parameter", Implementation.Parameter.class);
        xstream.addImplicitCollection(Implementation.class, "component", "oml:component", Implementation.Component.class);
        xstream.addImplicitCollection(Implementation.class, "tag", "oml:tag", String.class);

        xstream.aliasField("oml:id", Implementation.class, "id");
        xstream.aliasField("oml:fullName", Implementation.class, "fullName");
        xstream.aliasField("oml:name", Implementation.class, "name");
        xstream.aliasField("oml:version", Implementation.class, "version");
        xstream.aliasField("oml:external_version", Implementation.class, "external_version");
        xstream.aliasField("oml:uploader", Implementation.class, "uploader");
        xstream.aliasField("oml:upload_date", Implementation.class, "upload_date");
        xstream.aliasField("oml:description", Implementation.class, "description");
        xstream.aliasField("oml:licence", Implementation.class, "licence");
        xstream.aliasField("oml:language", Implementation.class, "language");
        xstream.aliasField("oml:full_description", Implementation.class, "full_description");
        xstream.aliasField("oml:installation_notes", Implementation.class, "installation_notes");
        xstream.aliasField("oml:dependencies", Implementation.class, "dependencies");

        xstream.aliasField("oml:source_url", Implementation.class, "source_url");
        xstream.aliasField("oml:source_format", Implementation.class, "source_format");
        xstream.aliasField("oml:source_md5", Implementation.class, "source_md5");

        xstream.aliasField("oml:binary_url", Implementation.class, "binary_url");
        xstream.aliasField("oml:binary_format", Implementation.class, "binary_format");
        xstream.aliasField("oml:binary_md5", Implementation.class, "binary_md5");

        // implementation component
        xstream.alias("oml:implementation_component", Implementation.Component.class);
        xstream.aliasField("oml:identifier", Implementation.Component.class, "identifier");
        xstream.aliasField("oml:implementation", Implementation.Component.class, "implementation");

        // bibliographical reference
        xstream.alias("oml:bibliographical_reference", Implementation.Bibliographical_reference.class);
        xstream.aliasField("oml:citation", Implementation.Bibliographical_reference.class, "citation");
        xstream.aliasField("oml:url", Implementation.Bibliographical_reference.class, "url");

        // parameter
        xstream.alias("oml:parameter", Implementation.Parameter.class);
        xstream.aliasField("oml:name", Implementation.Parameter.class, "name");
        xstream.aliasField("oml:data_type", Implementation.Parameter.class, "data_type");
        xstream.aliasField("oml:default_value", Implementation.Parameter.class, "default_value");
        xstream.aliasField("oml:description", Implementation.Parameter.class, "description");

        // upload implementation
        xstream.alias("oml:upload_implementation", UploadImplementation.class);
        xstream.aliasField("oml:id", UploadImplementation.class, "id");

        // owned implementation
        xstream.addImplicitCollection(ImplementationOwned.class, "id", "oml:id", Integer.class);
        xstream.alias("oml:implementation_owned", ImplementationOwned.class);
        xstream.aliasField("oml:id", ImplementationOwned.class, "id");

        // delete implementation
        xstream.alias("oml:implementation_delete", ImplementationDelete.class);
        xstream.aliasField("oml:id", ImplementationDelete.class, "id");

        // implementation exists
        xstream.alias("oml:implementation_exists", ImplementationExists.class);
        xstream.aliasField("oml:exists", ImplementationExists.class, "exists");
        xstream.aliasField("oml:id", ImplementationExists.class, "id");

        // generic error
        xstream.alias("oml:error", ApiError.class);
        xstream.aliasAttribute(ApiError.class, "oml", "xmlns:oml");
        xstream.aliasField("oml:code", ApiError.class, "code");
        xstream.aliasField("oml:message", ApiError.class, "message");
        xstream.aliasField("oml:additional_information", ApiError.class, "additional_information");

        // authenticate
        xstream.alias("oml:authenticate", Authenticate.class);
        xstream.aliasField("oml:session_hash", Authenticate.class, "sessionHash");
        xstream.aliasField("oml:valid_until", Authenticate.class, "validUntil");
        xstream.aliasField("oml:timezone", Authenticate.class, "timezone");

        // tasks
        xstream.alias("oml:task", Task.class);
        xstream.alias("oml:data_set", Task.Input.Data_set.class);
        xstream.alias("oml:estimation_procedure", Task.Input.Estimation_procedure.class);
        xstream.alias("oml:feature", Task.Output.Predictions.Feature.class);
        xstream.aliasField("oml:cost_matrix", Task.Input.class, "cost_matrix");
        xstream.aliasAttribute(Task.class, "oml", "xmlns:oml");

        xstream.addImplicitCollection(Task.class, "inputs", "oml:input", Task.Input.class);
        xstream.addImplicitCollection(Task.class, "outputs", "oml:output", Task.Output.class);
        xstream.addImplicitCollection(Task.class, "tag", "oml:tag", String.class);
        xstream.addImplicitCollection(Task.Input.Estimation_procedure.class, "parameters", "oml:parameter", Task.Input.Estimation_procedure.Parameter.class);
        xstream.addImplicitCollection(Task.Input.Evaluation_measures.class, "evaluation_measure", "oml:evaluation_measure", String.class);
        xstream.addImplicitCollection(Task.Output.Predictions.class, "features", "oml:feature", Task.Output.Predictions.Feature.class);

        xstream.aliasField("oml:task_id", Task.class, "task_id");
        xstream.aliasField("oml:task_type", Task.class, "task_type");
        xstream.aliasField("oml:data_set_id", Task.Input.Data_set.class, "data_set_id");
        xstream.aliasField("oml:labeled_data_set_id", Task.Input.Data_set.class, "labeled_data_set_id");
        xstream.aliasField("oml:target_feature", Task.Input.Data_set.class, "target_feature");
        xstream.aliasField("oml:target_feature_left", Task.Input.Data_set.class, "target_feature_left");
        xstream.aliasField("oml:target_feature_right", Task.Input.Data_set.class, "target_feature_right");
        xstream.aliasField("oml:target_feature_event", Task.Input.Data_set.class, "target_feature_event");
        xstream.aliasField("oml:data_set", Task.Input.class, "data_set");
        xstream.aliasField("oml:type", Task.Input.Estimation_procedure.class, "type");
        xstream.aliasField("oml:data_splits_url", Task.Input.Estimation_procedure.class, "data_splits_url");
        xstream.aliasField("oml:estimation_procedure", Task.Input.class, "estimation_procedure");
        xstream.aliasField("oml:evaluation_measure", Task.Input.Evaluation_measures.class, "evaluation_measure");
        xstream.aliasField("oml:evaluation_measures", Task.Input.class, "evaluation_measures");
        xstream.aliasField("oml:predictions", Task.Output.class, "predictions");
        xstream.aliasField("oml:format", Task.Output.Predictions.class, "format");
        xstream.omitField(Task.Input.Estimation_procedure.class, "data_splits_cache");
        xstream.omitField(Task.Input.Data_set.class,"dsdCache");

        xstream.useAttributeFor(Task.Input.class, "name");
        xstream.useAttributeFor(Task.Output.class, "name");
        xstream.useAttributeFor(Task.Input.Estimation_procedure.Parameter.class, "name");
        xstream.useAttributeFor(Task.Output.Predictions.Feature.class, "name");
        xstream.useAttributeFor(Task.Output.Predictions.Feature.class, "type");

        xstream.registerConverter(new ToAttributedValueConverter(Task.Input.Estimation_procedure.Parameter.class, xstream.getMapper(), xstream.getReflectionProvider(), xstream.getConverterLookup(), "value"));

        // task evaluation
        xstream.alias("oml:task_evaluations", TaskEvaluations.class );
        xstream.aliasField("oml:task_id", TaskEvaluations.class, "task_id");
        xstream.aliasField("oml:task_name", TaskEvaluations.class, "task_name");
        xstream.aliasField("oml:task_type_id", TaskEvaluations.class, "task_type_id");
        xstream.aliasField("oml:input_data", TaskEvaluations.class, "input_data");
        xstream.aliasField("oml:estimation_procedure", TaskEvaluations.class, "estimation_procedure");

        xstream.addImplicitCollection(TaskEvaluations.class, "evaluation", "oml:evaluation", TaskEvaluations.Evaluation.class);
        xstream.aliasField("oml:run_id",TaskEvaluations.Evaluation.class, "run_id");
        xstream.aliasField("oml:setup_id",TaskEvaluations.Evaluation.class, "setup_id");
        xstream.aliasField("oml:implementation_id",TaskEvaluations.Evaluation.class,"implementation_id");
        xstream.aliasField("oml:implementation",TaskEvaluations.Evaluation.class,"implementation");
        xstream.useAttributeFor(TaskEvaluations.Evaluation.class, "interval_start");
        xstream.useAttributeFor(TaskEvaluations.Evaluation.class, "interval_end");

        xstream.addImplicitCollection(TaskEvaluations.Evaluation.class, "measure", "oml:measure", TaskEvaluations.Evaluation.Measure.class);
        xstream.useAttributeFor(TaskEvaluations.Evaluation.Measure.class, "name");
        xstream.registerConverter(new ToAttributedValueConverter(TaskEvaluations.Evaluation.Measure.class, xstream.getMapper(), xstream.getReflectionProvider(), xstream.getConverterLookup(), "value"));

        // tasks (overview)
        xstream.alias("oml:tasks", Tasks.class );
        xstream.addImplicitCollection(Tasks.class, "task", "oml:task", Tasks.Task.class);

        xstream.aliasField("oml:task_id", Tasks.Task.class, "task_id");
        xstream.aliasField("oml:task_type", Tasks.Task.class, "task_type");
        xstream.aliasField("oml:did", Tasks.Task.class, "did");
        xstream.aliasField("oml:name", Tasks.Task.class, "name");
        xstream.aliasField("oml:status", Tasks.Task.class, "status");
        xstream.addImplicitCollection(Tasks.Task.class, "qualities", "oml:quality", Tasks.Task.Quality.class);
        xstream.useAttributeFor(Tasks.Task.Quality.class, "name");
        xstream.registerConverter(new ToAttributedValueConverter(Tasks.Task.Quality.class, xstream.getMapper(), xstream.getReflectionProvider(), xstream.getConverterLookup(), "value"));



        // run
        xstream.alias("oml:run", Run.class);
        xstream.aliasAttribute(Run.class, "oml", "xmlns:oml");
        xstream.addImplicitCollection(Run.class, "parameter_settings", "oml:parameter_setting", Run.Parameter_setting.class);
        xstream.addImplicitCollection(Run.class, "tag", "oml:tag", String.class);

        xstream.aliasField("oml:task_id", Run.class, "task_id");
        xstream.aliasField("oml:implementation_id", Run.class, "implementation_id");
        xstream.aliasField("oml:error_message", Run.class, "error_message");
        xstream.aliasField("oml:setup_string", Run.class, "setup_string");
        xstream.aliasField("oml:input_data", Run.class, "input_data");
        xstream.aliasField("oml:output_data", Run.class, "output_data");

        xstream.aliasField("oml:name", Run.Parameter_setting.class, "name");
        xstream.aliasField("oml:component", Run.Parameter_setting.class, "component");
        xstream.aliasField("oml:value", Run.Parameter_setting.class, "value");

        xstream.addImplicitCollection( Run.Data.class, "dataset", "oml:dataset", Run.Data.Dataset.class);
        xstream.addImplicitCollection( Run.Data.class, "evaluation", "oml:evaluation", EvaluationScore.class);

        xstream.aliasField("oml:did", Run.Data.Dataset.class, "did");
        xstream.aliasField("oml:name", Run.Data.Dataset.class, "name");
        xstream.aliasField("oml:url", Run.Data.Dataset.class, "url");

        xstream.aliasField("oml:did", EvaluationScore.class, "did");
        xstream.aliasField("oml:name", EvaluationScore.class, "function"); // TODO: inconsistency? change?
        xstream.aliasField("oml:implementation", EvaluationScore.class, "implementation");
        xstream.aliasField("oml:value", EvaluationScore.class, "value");
        xstream.aliasField("oml:array_data", EvaluationScore.class, "array_data");
        xstream.aliasField("oml:sample_size", EvaluationScore.class, "sample_size");

        xstream.useAttributeFor(EvaluationScore.class, "repeat");
        xstream.useAttributeFor(EvaluationScore.class, "fold");
        xstream.useAttributeFor(EvaluationScore.class, "sample");
        xstream.useAttributeFor(EvaluationScore.class, "interval_start");
        xstream.useAttributeFor(EvaluationScore.class, "interval_end");

        // upload run
        xstream.alias("oml:upload_run", UploadRun.class);
        xstream.aliasField("oml:run_id", UploadRun.class, "run_id");

        // reset run
        xstream.alias("oml:run_reset", RunReset.class);
        xstream.aliasField("oml:id", RunReset.class, "run_id");

        // delete run
        xstream.alias("oml:run_delete", RunDelete.class);
        xstream.aliasField("oml:id", RunDelete.class, "id");

        // run evaluate
        xstream.alias("oml:run_evaluate", RunEvaluate.class);
        xstream.aliasField("oml:run_id", RunEvaluate.class, "run_id");

        // reset run
        xstream.alias("oml:file_upload", FileUpload.class);
        xstream.aliasField("oml:id", FileUpload.class, "id");
        xstream.aliasField("oml:url", FileUpload.class, "url");

        // run getjob
        xstream.alias("oml:job", Job.class);
        xstream.aliasField("oml:task_id", Job.class, "task_id");
        xstream.aliasField("oml:learner", Job.class, "learner");

        // run evaluation
        xstream.alias("oml:run_evaluation", RunEvaluation.class);
        xstream.aliasAttribute(RunEvaluation.class, "oml", "xmlns:oml");
        xstream.aliasField("oml:run_id", RunEvaluation.class, "run_id");
        xstream.aliasField("oml:error", RunEvaluation.class, "error");
        xstream.addImplicitCollection(RunEvaluation.class, "evaluation", "oml:evaluation", EvaluationScore.class);

        // data tag
        xstream.alias("oml:data_tag", DataTag.class);
        xstream.aliasField("oml:id", DataTag.class, "id");
        // implementation tag
        xstream.alias("oml:implementation_tag", ImplementationTag.class);
        xstream.aliasField("oml:id", ImplementationTag.class, "id");
        // setup tag
        xstream.alias("oml:setup_tag", SetupTag.class);
        xstream.aliasField("oml:id", SetupTag.class, "id");
        // task tag
        xstream.alias("oml:task_tag", TaskTag.class);
        xstream.aliasField("oml:id", TaskTag.class, "id");
        // run tag
        xstream.alias("oml:run_tag", RunTag.class);
        xstream.aliasField("oml:id", RunTag.class, "id");

        return xstream;
    }
}
