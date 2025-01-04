# AWS CLI Commands - Localstack

### IAM

#### User

---
##### List Users

```
aws --endpoint-url=http://localhost:4566 iam list-users
```

<img src="../../Screenshots/AWS-CLI/IAM/1ListUsers.png">

##### Create ROOT User

```
aws --endpoint-url=http://localhost:4566 iam create-user --user-name root
```

```
aws --endpoint-url=http://localhost:4566 iam list-users
```

<img src="../../Screenshots/AWS-CLI/IAM/2CreateRootUser.png">

##### Create ROOT Users ACCESS & SECRET Keys

```
aws --endpoint-url=http://localhost:4566 iam create-access-key --user root
```

<img src="../../Screenshots/AWS-CLI/IAM/3CreateRootUserAccessAndSecretKeys.png">

##### Configuring AWS CLI

```
aws configure --profile local
```

<img src="../../Screenshots/AWS-CLI/IAM/4ConfigureAWSCLILocalProfile.png">

##### Create DEV User

```
aws --endpoint-url=http://localhost:4566 iam create-user --user-name devuser
```

```
aws --endpoint-url=http://localhost:4566 iam list-users
```

<img src="../../Screenshots/AWS-CLI/IAM/5CreateDevUser.png">

##### Create DEV User ACCESS & SECRET Keys

```
aws --endpoint-url=http://localhost:4566 iam create-access-key --user devuser
```

<img src="../../Screenshots/AWS-CLI/IAM/6CreateDevUserAccessAndSecretKeys.png">

##### Configuring AWS CLI for DEV User

```
aws configure --profile dev-local
```

<img src="../../Screenshots/AWS-CLI/IAM/7ConfigureAWSCLIDevLocalProfile.png">

#### Groups

---

#### List Groups

```
aws --endpoint-url=http://localhost:4566 iam list-groups
```

<img src="../../Screenshots/AWS-CLI/IAM/8ListGroups.png">

#### Create Group

```
aws --endpoint-url=http://localhost:4566 iam create-group --group-name developers
```

```
aws --endpoint-url=http://localhost:4566 iam create-group --group-name tester
```

```
aws --endpoint-url=http://localhost:4566 iam list-groups
```

<img src="../../Screenshots/AWS-CLI/IAM/9CreateGroups.png">

#### Add User to the Group

Adding to Group `developers`

```
aws --endpoint-url=http://localhost:4566 iam add-user-to-group --group-name developers --user-name devuser
```

Adding to Group `tester`

```
aws --endpoint-url=http://localhost:4566 iam add-user-to-group --group-name tester --user-name devuser
```

Listing all groups of a User

```
aws --endpoint-url=http://localhost:4566 iam list-groups-for-user --user-name devuser
```

<img src="../../Screenshots/AWS-CLI/IAM/10AddUserToGroup.png">

```
aws --endpoint-url=http://localhost:4566 iam get-group --group-name developers
```

```
aws --endpoint-url=http://localhost:4566 iam get-group --group-name tester
```

<img src="../../Screenshots/AWS-CLI/IAM/11GetGroups.png">

#### Update User's Group

```
aws --endpoint-url=http://localhost:4566 iam update-group --group-name tester --new-group-name testers
```

```
aws --endpoint-url=http://localhost:4566 iam get-group --group-name testers
```

<img src="../../Screenshots/AWS-CLI/IAM/12UpdateGroup.png">
