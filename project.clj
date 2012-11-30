(defproject
  lein-deploy-app "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :plugins [[lein-cljsbuild "0.2.9"]]
  :dependencies [[clj-aws-s3 "0.3.1"]
                 ]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  :s3 {:bucket "wei-test-123214214"
       :root "/Users/wei/projects/clojure/advent/resources/public/"
       :files ["js/bin/main.js"]
       })
