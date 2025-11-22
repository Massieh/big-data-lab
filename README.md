# Steps to Run

Configure Terraform
Edit terraform.tfvars with your desired settings (region, instance types, etc.).

terraform init
terraform apply

grab the IPs and write them in inventory.yaml

ansible-playbook install_spark.yml

ansible-playbook compile_and_run.yml
