# Install and Setup Docker on Amazon EC2 - Amazon Linux 2023

### Login to EC2 Instance

```
ssh -i "AshokAirflowInstance.pem" ec2-user@ec2-52-207-141-50.compute-1.amazonaws.com
```

### Update OS Packages

```
sudo yum update -y
```

### Install Docker

```
sudo yum install docker -y
```

### Add User to `docker` group

```
sudo usermod -a -G docker ec2-user
```

### Check user groups

```
id ec2-user
```

### Join docker group - if not already exists

```
newgrp docker
```

### Start the docker server

```
sudo systemctl start docker.service
```

### Enabling docker service at boot time

```
sudo systemctl enable docker.service
```

### Checking the docker service status

```
sudo systemctl status docker.service
```

### Checking docker version

```
docker -v
```

# Installing docker-compose

### Download docker-compose script

```
wget https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)
```

### Move the docker-compose script to bin directory

```
sudo mv docker-compose-$(uname -s)-$(uname -m) /usr/local/bin/docker-compose
```

### Add execute permission to the docker-compose script

```
sudo chmod -v +x /usr/local/bin/docker-compose
```

### Check docker-compose version

```
docker-compose -v
```

# Install kubectl Client and configuring with EKS K8S Cluster

### Download kubectl script

```
curl -O https://s3.us-west-2.amazonaws.com/amazon-eks/1.28.3/2023-11-14/bin/linux/amd64/kubectl
```

### Add execute permission to kubectl script

```
chmod +x ./kubectl
```

### Move the script to User bin directory and exporting PATH variable

```
mkdir -p $HOME/bin && cp ./kubectl $HOME/bin/kubectl && export PATH=$HOME/bin:$PATH
```

### Adding User bin to PATH and to .bashrc file

```
echo 'export PATH=$HOME/bin:$PATH' >> ~/.bashrc
```

### Checking kubectl client version

```
kubectl version --client
```

### Configuring AWS CLI

```
aws configure
```

### Configuring Amazon EKS Cluster

```
aws eks update-kubeconfig --region us-east-1 --name my-k8s-cluster1
```
