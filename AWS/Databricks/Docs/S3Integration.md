# DATA INGESTION FROM S3 IN DATABRICKS

### Login to Workspace

<img src="../../Screenshots/S3DatabricksIntegration/0DatabricksWorkspaceLogin.png">

### Select `Data Ingestion` under `Data Engineering` section on Workspace Home page

<img src="../../Screenshots/S3DatabricksIntegration/1DataIngestion.png">

### Select `Amazon S3` under Native integrations from the list of data sources under `Data Ingestion` section

<img src="../../Screenshots/S3DatabricksIntegration/2SelectS3.png">

### Click on `+` symbol to add an external connection to Amazon S3

<img src="../../Screenshots/S3DatabricksIntegration/3AddS3ExternalConnection.png">

### Select `AWS Quickstart (Recommended)` for creating a new external location and click on Next

<img src="../../Screenshots/S3DatabricksIntegration/4AddS3ExternalConnectionQuickstart.png">

### Provide the existing Amazon S3 Bucket Name under `Bucket Name` and `Click on Generate New Token`

In this case `ashok-input-data-for-databricks` is used for an example.

<img src="../../Screenshots/S3DatabricksIntegration/5S3BucketNameAndToken1.png">

### Copy the generated Personal Access Token and click on `Launch in Quickstart`

<img src="../../Screenshots/S3DatabricksIntegration/5S3BucketNameAndToken2.png">

Note: After clicking on Launch in Quickstart, it will navigate to the Create Stack section of AWS CloudFormation 

### Paste the Personal Access Token in `Databricks Personal Access Token` text under `Databricks Account Credentials`

<img src="../../Screenshots/S3DatabricksIntegration/6CloudFormationStack1.png">

### Confirm the `Databricks account ID` under `Databricks Account Credentials`, then `acknowledge` and click on `Create Stack`

<img src="../../Screenshots/S3DatabricksIntegration/6CloudFormationStack2.png">

### Wait until the CloudFormation Stack is successful

<img src="../../Screenshots/S3DatabricksIntegration/6CloudFormationStack3.png">

Note: Once the CloudFormation Stack is successfully created, we will be able to access AWS S3 bucket from Databricks workspace.

### Now the AWS S3 Bucket is added to the external locations of Amazon S3 list under `Data Ingestion` section

<img src="../../Screenshots/S3DatabricksIntegration/7SelectS3Bucket.png">

### Select the external location binding to the Amazon S3 Bucket and then we will be to see all the objects exists in the Bucket. 

<img src="../../Screenshots/S3DatabricksIntegration/8ListS3Bucket.png">

<img src="../../Screenshots/S3DatabricksIntegration/8ListS3Bucket2.png">

### Access the file / objects exists in the Amazon S3 bucket in Databricks Notebooks like follows

<img src="../../Screenshots/S3DatabricksIntegration/9AccessS3FilesFromDatabricksNotebook.png">
