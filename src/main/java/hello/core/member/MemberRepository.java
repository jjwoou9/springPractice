package hello.core.member;

public interface MemberRepository {

	void Save(Member member);
	
	Member findById(Long memberId);
	
}
