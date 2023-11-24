# Installing Terraform on Amazon EC2 - Amazon Linux 2023 

### Login to EC2 Instance

```
ssh -i "AshokAirflowInstance.pem" ec2-user@ec2-52-207-141-50.compute-1.amazonaws.com
```

<img src="../Screenshots/Terraform/1SSHToEC2.png">

### Update OS Packages

```
sudo yum update -y
```

<img src="../Screenshots/Terraform/2YumUpdate.png">

### Install YUM Utils

```
sudo yum install -y yum-utils
```

<img src="../Screenshots/Terraform/3YumUtilsInstall.png">

### Add Terraform repo

```
sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/AmazonLinux/hashicorp.repo
```

<img src="../Screenshots/Terraform/4AddTerraformRepo.png">

### Install Terraform

```
sudo yum -y install terraform
```

<img src="../Screenshots/Terraform/5InstallTerraform.png">