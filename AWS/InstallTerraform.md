ssh -i "AshokAirflowInstance.pem" ec2-user@ec2-52-207-141-50.compute-1.amazonaws.com

sudo yum update -y

sudo yum install -y yum-utils

sudo yum-config-manager --add-repo https://rpm.releases.hashicorp.com/AmazonLinux/hashicorp.repo

sudo yum -y install terraform

