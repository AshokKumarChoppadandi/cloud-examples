# Install and Configure Databricks CLI on Amazon EC2 - Amazon Linux 2023


## Login to Amazon EC2 instance

```
ssh -i "AshokWindows.pem" ec2-user@ec2-54-227-71-93.compute-1.amazonaws.com
```

<img src="../Screenshots/DatabricksCLI/1SSHEC2.png">

## Update OS packages

```
sudo yum update -y
```

<img src="../Screenshots/DatabricksCLI/2UpdatePackages.png">

## Check `curl` version (Install if not exists) 

```
curl -V
```

<img src="../Screenshots/DatabricksCLI/3CurlVersion.png">

## Download Databricks CLI installation script and install

```
curl -fsSL https://raw.githubusercontent.com/databricks/setup-cli/main/install.sh | sudo sh
```

<img src="../Screenshots/DatabricksCLI/4InstallDatabricksCLI.png">

## Check the installed Databricks CLI Version

```
databricks -v
```

```
databricks version
```

<img src="../Screenshots/DatabricksCLI/5DatabricksVersion.png">

## Goto the `User Settings` section under the user profile in the Databricks Workspace

<img src="../Screenshots/DatabricksCLI/6DatabricksWorkspaceDetails.png">

## Goto the `Developer` settings and click on `Manage` to create `Access tokens`

<img src="../Screenshots/DatabricksCLI/7DatabricksAccessToken.png">

## Click on `Generate new token` to create a new Databricks Personal Access Token

<img src="../Screenshots/DatabricksCLI/8DatabricksAccessTokenGenerate.png">

## Add a `Comment` and `Lifetime (days)` to Generate new token and click on `Generate` 

<img src="../Screenshots/DatabricksCLI/8DatabricksAccessTokenGenerate2.png">

## `Copy` the newly generated Databricks personal Access Token and click on `Done`

<img src="../Screenshots/DatabricksCLI/9DatabricksAccessTokenCopy.png">

## Goto the Databricks Workspace and get the Workspace URL

<img src="../Screenshots/DatabricksCLI/10DatabricksWorkspaceURL.png">

## Goto the Terminal and execute the Databricks configure command

```
databricks configure
```

* Shell will be prompted to enter the Databricks Workspace URL and Access Token

* Enter the Databricks Workspace URL, for example: `https://dbc-fe798a27-7679.cloud.databricks.com/`

* Enter the Databricks Personal Access Token, for example: `dapic910338f068fa3eb2e9d01ecdc8336ee`

<img src="../Screenshots/DatabricksCLI/11DatabricksConfigure.png">

## Execute Databricks CLI Commands to verify

```
databricks clusters list
```

<img src="../Screenshots/DatabricksCLI/12DatabricksClustersList.png">
