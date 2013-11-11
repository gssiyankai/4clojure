(ns game_of_life_test
  (:use clojure.test)
  (:use game_of_life))

(deftest test-1
  (is (= (next-generation ["      "
                           " ##   "
                           " ##   "
                           "   ## "
                           "   ## "
                           "      "])
                          ["      "
                           " ##   "
                           " #    "
                           "    # "
                           "   ## "
                           "      "])))

(deftest test-2
  (is (= (next-generation ["     "
                           "     "
                           " ### "
                           "     "
                           "     "])
                          ["     "
                           "  #  "
                           "  #  "
                           "  #  "
                           "     "])))

(deftest test-3
  (is (= (next-generation ["      "
                           "      "
                           "  ### "
                           " ###  "
                           "      "
                           "      "])
                          ["      "
                           "   #  "
                           " #  # "
                           " #  # "
                           "  #   "
                           "      "])))

(run-tests 'game_of_life_test)