# Setting up Apache Airflow on Amazon EC2 - Amazon Linux 2023

#### Login to EC2 Instance

```
ssh -i "AshokWindows.pem" ec2-user@ec2-3-93-49-17.compute-1.amazonaws.com
```

<img src="../Screenshots/Airflow/1SSHEC2.png">

#### Update OS Packages

```
sudo yum update -y
```

<img src="../Screenshots/Airflow/2UpdatePackages.png">

#### Install Python 3

```
sudo yum install python3 -y
```

<img src="../Screenshots/Airflow/3InstallPython3.png">

#### Install Pip

```
sudo yum install python-pip -y
```

<img src="../Screenshots/Airflow/4InstallPip.png">

#### Check Python & Pip versions

```
python3 --version

pip --version
```

<img src="../Screenshots/Airflow/5PythonAndPipVersion.png">

#### Install Apache Airflow

```
pip install apache-airflow
```

<img src="../Screenshots/Airflow/6InstallAirflow1.png">

<img src="../Screenshots/Airflow/6InstallAirflow2.png">

#### Install Apache Airflow Databricks Provider libraries

```
pip install apache-airflow-providers-databricks
```

<img src="../Screenshots/Airflow/7InstallDatabricksProviderAirflowPackages1.png">

<img src="../Screenshots/Airflow/7InstallDatabricksProviderAirflowPackages2.png">

#### Initialise Airflow DB

```
airflow db init
```

<img src="../Screenshots/Airflow/8InitializingSQLiteDBForAirflow.png">

#### Create Airflow Admin User

```
airflow users create --username admin --firstname ashok --lastname kumar  --role Admin --email ashok@test.com
```

<img src="../Screenshots/Airflow/9CreateAdminUser.png">

#### Start Airflow Webserver

```
airflow webserver --port 8080
```

<img src="../Screenshots/Airflow/10StartAirflowWebServer1.png">

<img src="../Screenshots/Airflow/10StartAirflowWebServer2.png">

#### Start Airflow Scheduler

```
airflow scheduler
```

<img src="../Screenshots/Airflow/11StartAirflowScheduler.png">

#### Checking the status

```
ps -a
```

<img src="../Screenshots/Airflow/12ProcessList.png">

#### Allow inbound traffic for port 8080

<img src="../Screenshots/Airflow/13AllowInboundTraffic.png">

#### Login to Airflow Web UI

http://ec2-3-93-49-17.compute-1.amazonaws.com:8080

<img src="../Screenshots/Airflow/14AirflowWebUILogin.png">
