terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">=1.2.0"
}

provider "aws" {
  region = "us-east-1"
  access_key = "AKIAW5IZRWOYRXCYV7BI"
  secret_key = "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"
}

resource "aws_instance" "ashok-tf-instance-1" {
  ami = "ami-0230bd60aa48260c6"
  instance_type = "t2.micro"
  subnet_id = "subnet-0b0e8b87856866414"

  tags = {
    Name = "Ashok_Terraform_Instance"
  }
}