(ns leiningen.deploy-app
  (:require [aws.sdk.s3 :as s3]
            [clojure.java.io :as io]
            [leiningen.cljsbuild :as cljsbuild]))

(defn create-bucket [aws-creds bucket]
  (s3/create-bucket aws-creds bucket)
  (s3/update-bucket-acl aws-creds bucket (s3/grant :all-users :read)))

(defn deploy-to-s3 [aws-creds {:keys [bucket root files]}]
  (when-not (s3/bucket-exists? aws-creds bucket) (create-bucket aws-creds bucket))
  (doseq [file files]
    (s3/put-object aws-creds bucket file (io/file (str root file)))
    (s3/update-object-acl aws-creds bucket file (s3/grant :all-users :read))))

(defn deploy-app
  "Deploy assets to s3"
  [{aws-creds :aws-creds s3 :s3 :as project} & args]
  (println "using s3 opts " s3)
  (deploy-to-s3 aws-creds s3))
