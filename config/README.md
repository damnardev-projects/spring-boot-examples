## 1. Create a File with Your GPG Public Key

Create a `public.key` and `private.key` file containing your public and private keys, then run the following command:

```shell
cd config
./import.sh
```

## 2. Set Up GitHub Username and Email

Run the following Git commands to configure your GitHub username and email:

```shell
git config --global user.name "<your-username>"
git config --global user.email "<your-email>"
```