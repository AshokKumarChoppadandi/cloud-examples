
sudo yum update -y

sudo yum install docker -y

sudo usermod -a -G docker ec2-user
id ec2-user
newgrp docker

Docker Compose:

wget https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)
sudo mv docker-compose-$(uname -s)-$(uname -m) /usr/local/bin/docker-compose
sudo chmod -v +x /usr/local/bin/docker-compose


sudo systemctl enable docker.service

sudo systemctl start docker.service

sudo systemctl status docker.service

docker -v

docker-compose -v

curl -O https://s3.us-west-2.amazonaws.com/amazon-eks/1.28.3/2023-11-14/bin/linux/amd64/kubectl

chmod +x ./kubectl

mkdir -p $HOME/bin && cp ./kubectl $HOME/bin/kubectl && export PATH=$HOME/bin:$PATH

echo 'export PATH=$HOME/bin:$PATH' >> ~/.bashrc

kubectl version --client

aws configure

aws eks update-kubeconfig --region us-east-1 --name ashok-eks-cluster

