(ns clj-grep.core
  (:gen-class)
  (:require [clojure.core.reducers :as r]))

(defn file-path [file]
  (.getPath file))

(defn file-has-content? [file content]
  (let [pattern (re-pattern (str "(?x).*" content ".*"))
        file-content (slurp file)]
    (re-find pattern file-content)))

(defn recursive-ls [path]
  (file-seq (clojure.java.io/file path)))

(defn file? [file-or-directory]
  (.isFile file-or-directory))

(defn find-files-with-content [path content]
  (->> (recursive-ls path)
       (filter file?)
       (r/filter #(file-has-content? % content))
       (into [])))

(defn print-files-with-content [path content]
  (let [files (find-files-with-content path content)]
    (if (empty? files)
      (println "Nothing found")
      (do
        (println "Found in:")
        (doseq [file files]
          (println (file-path file)))))))

(defn -main
  [& args]
  (apply print-files-with-content args))
