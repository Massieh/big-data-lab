# Steps to Run

Configure Terraform
Edit terraform.tfvars with your desired settings.

terraform init
terraform apply

grab the IPs and write them in inventory.yaml

ansible-playbook -i inventory.yaml install_spark.yaml
ansible-playbook -i inventory.yaml compile_and_run.yaml
