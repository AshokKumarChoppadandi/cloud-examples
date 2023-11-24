# Databricks and Spark to process data in Relational Databases

The following setup is required to process the data from relational databases (Ex: `MySQL`)

* SQL Warehouse
* External Connection
* Create Catalog
* SQL Editor

#### Login to Databricks Workspace

<img src="../Screenshots/Databricks/SQLWarehouse/1DatabricksWorkspaceLogin.png">

## SQL Warehouse

#### Goto `SQL Warehouses` under `SQL` from the workspace home page and click on `Create SQL Warehouse`

<img src="../Screenshots/Databricks/SQLWarehouse/2CreateSQLWarehouseOption.png">

#### Provide the details for the `New SQL warehouse` and click on `Create`

The available options are:

* Name - (Ex: `ashok-sql-warehouse`)
* Cluster Size - (Ex: `2X-Small`)
* Auto stop - (Ex: `Enable`) After (Ex: `45`) minutes of inactivity
* Scaling Min. - (Ex: `1`) and Max. - (Ex: `1`)
* Type (Ex: `Pro`)

<img src="../Screenshots/Databricks/SQLWarehouse/3CreateNewSQLWarehouse.png">

#### `Manage permissions` for the newly created SQL Warehouse and close the pop-up

<img src="../Screenshots/Databricks/SQLWarehouse/4SQLWarehousePermissions.png">

#### Wait for the cluster to be active and ready

<img src="../Screenshots/Databricks/SQLWarehouse/5SQLWarehouseStarting.png">


## External Connection

To create an external connection with an RDBMS (Ex: `MySQL`) follow the below steps:

#### Goto `Catalog` section from the workspace home page

<img src="../Screenshots/Databricks/SQLWarehouse/6WorkspaceCatalog.png">

#### Under `Catalog` click on the `External Data` in the `Catalog Explorer`

<img src="../Screenshots/Databricks/SQLWarehouse/7CatalogExternalData.png">

#### Select `Connections` under `External Data` and click on `Create Connection`

<img src="../Screenshots/Databricks/SQLWarehouse/8CreateConnectionOption.png">

#### Configure parameters to `Create a new connection`

The following configuration parameters are available to configure:

* Connection name - (Ex: `ashok-mysql`)
* Connection type - (Ex: `MySQL`)
* User - (Ex: `root`)
* Password
* Host - (Ex: `ec2-54-227-71-93.compute-1.amazonaws.com`)
* Port - (Ex: `3306`)

After providing all the configuration parameters, `Test connection` and click on `Create`

<img src="../Screenshots/Databricks/SQLWarehouse/9CreateConnection.png">

#### View Connection Details under `External Data` & `Connections` in the `Catalog` section

<img src="../Screenshots/Databricks/SQLWarehouse/10RDSConnectionDetails.png">

## Create Catalog

#### Goto `Catalog` option in the `Catalog Explorer`

<img src="../Screenshots/Databricks/SQLWarehouse/11CreateCatalogOption.png">

#### Select the connection details to `Create a new catalog` and click on `Create`

Provide the following details:

* Catalog name - (Ex: `ashok-mysql-catalog`)
* Type - (Ex: `Foreign`)
* Connection - (Ex: `ashok-mysql` - External connection created in the previous step)

<img src="../Screenshots/Databricks/SQLWarehouse/12CreateCatalog.png">

#### View the catalog details

<img src="../Screenshots/Databricks/SQLWarehouse/13CatalogDetails.png">

## Click on `SQL Editor` under `SQL` section to start executing the Queries on external RDBMS (Ex: `MySQL`)

Before executing the Queries, make sure the options are properly selected:

* Correct catalog - (Ex: `ashok-mysql-catalog`)
* Correct database - (Ex: `db1`)
* Correct SQL Warehouse - (Ex: `ashok-sql-warehouse`)
* Status of the SQL Warehouse - (Ex: `Active`)

Once everything is ready write the queries and execute by clicking on `Run (1000)` button

<img src="../Screenshots/Databricks/SQLWarehouse/14ExecutingSQLQueries.png">