aws iam create-role \
    --role-name ashok-lambda-role-new \
    --assume-role-policy-document '
        {
            "Version": "1.0",
            "Statement": [
                {
                    "Effect": "Allow", 
                    "Principal": 
                        {
                            "Service": "lambda.amazonaws.com"
                        }, 
                        "Action": "sts:AssumeRole"
                }
            ]
        }'