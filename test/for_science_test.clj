(ns for_science_test
  (:use clojure.test)
  (:use for_science))

(deftest test-1
  (is (= true (can-reach-cheese ["M   C"]))))

(deftest test-2
  (is (= false (can-reach-cheese ["M # C"]))))

(deftest test-3
  (is (= true (can-reach-cheese ["#######"
                                 "#     #"
                                 "#  #  #"
                                 "#M # C#"
                                 "#######"]))))

(deftest test-4
  (is (= false (can-reach-cheese ["########"
                                  "#M  #  #"
                                  "#   #  #"
                                  "# # #  #"
                                  "#   #  #"
                                  "#  #   #"
                                  "#  # # #"
                                  "#  #   #"
                                  "#  #  C#"
                                  "########"]))))

(deftest test-5
  (is (= false (can-reach-cheese ["M     "
                                  "      "
                                  "      "
                                  "      "
                                  "    ##"
                                  "    #C"]))))

(deftest test-6
  (is (= true (can-reach-cheese ["C######"
                                 " #     "
                                 " #   # "
                                 " #   #M"
                                 "     # "]))))

(deftest test-7
  (is (= true (can-reach-cheese ["C# # # #"
                                 "        "
                                 "# # # # "
                                 "        "
                                 " # # # #"
                                 "        "
                                 "# # # #M"]))))

(run-tests 'for_science_test)