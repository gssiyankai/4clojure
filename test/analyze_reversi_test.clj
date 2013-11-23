(ns analyze_reversi_test
  (:use clojure.test)
  (:use analyze_reversi))

(deftest test-0
  (is (= [[1 1] [2 2 ]]
        (coordinates '[[e e e e]
                       [e w b e]
                       [e b w e]
                       [e e e e]] 'w)))
  (is (= [[1 2] [2 1]]
        (coordinates '[[e e e e]
                       [e w b e]
                       [e b w e]
                       [e e e e]] 'b)))
  (is (= 'b (opponent 'w)))
  (is (= 'w (opponent 'b)))
  (is (= { [1 3] #{[1 2]} }
        (moves '[[e e e e]
                 [e w b e]
                 [e e e e]
                 [e e e e]] 'w))))

(deftest test-1
  (is (= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
        (moves '[[e e e e]
                 [e w b e]
                 [e b w e]
                 [e e e e]] 'w))))

(deftest test-2
  (is (= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
        (moves '[[e e e e]
                 [e w b e]
                 [w w w e]
                 [e e e e]] 'b))))

(deftest test-3
  (is (= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
        (moves '[[e e e e]
                 [e w b e]
                 [w w b e]
                 [e e b e]] 'w))))

(deftest test-4
  (is (= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
        (moves '[[e e w e]
                 [b b w e]
                 [b w w e]
                 [b w w w]] 'b))))

(run-tests 'analyze_reversi_test)