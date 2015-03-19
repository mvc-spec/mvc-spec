cd /tmp
git clone --bare ssh://spericas@git.java.net/mvc-spec~git
cd mvc-spec~git.git
git push --mirror https://github.com/spericas/mvc-spec.git
cd ..
rm -rf mvc-spec~git.git

